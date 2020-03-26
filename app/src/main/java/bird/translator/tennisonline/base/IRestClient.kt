package bird.translator.tennisonline.base

interface IRestClient {

    fun <S> createService(serviceClass: Class<S>): S

    fun cancelAllRequests()
}