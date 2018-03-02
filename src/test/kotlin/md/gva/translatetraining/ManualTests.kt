package md.gva.translatetraining

import md.gva.translatetraining.service.PhrasesService

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
fun main(args: Array<String>) {
    val service = PhrasesService()
    print(service.getPhrases("Wissenschaft"))
}