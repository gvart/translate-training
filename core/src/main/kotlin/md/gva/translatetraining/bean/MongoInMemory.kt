package md.gva.translatetraining.bean

import de.flapdoodle.embed.mongo.Command
import de.flapdoodle.embed.mongo.distribution.Version
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import de.flapdoodle.embed.mongo.MongodProcess
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.*
import de.flapdoodle.embed.process.config.io.ProcessOutput
import de.flapdoodle.embed.process.extract.UserTempNaming


class MongoInMemory(private val port: Int, private val host: String) {

    private var process: MongodProcess? = null
    private val storage = Storage(System.getProperty("user.home") + "/.ttraining-storage",
            null, 0)

    @PostConstruct
    fun init() {
        val runtimeConfig = RuntimeConfigBuilder()
                .defaults(Command.MongoD)
                .processOutput(ProcessOutput.getDefaultInstanceSilent())
                .artifactStore(ExtractedArtifactStoreBuilder()
                        .defaults(Command.MongoD)
                        .download(DownloadConfigBuilder()
                                .defaultsForCommand(Command.MongoD).build())
                        .executableNaming(UserTempNaming()))
                .build()

        val mongodConfig = MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(Net(host, port, false))
                .replication(storage)
                .build()

        val runtime = MongodStarter.getInstance(runtimeConfig)
        process = runtime.prepare(mongodConfig).start()
    }

    @PreDestroy
    fun stop() {
        process?.stop()
    }
}