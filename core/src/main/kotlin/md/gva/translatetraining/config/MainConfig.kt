package md.gva.translatetraining.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * @author Gladîș Vladlen on 3/3/18.
 */
@Configuration
@EnableMongoRepositories("md.gva.translatetraining.repository")
class MainConfig