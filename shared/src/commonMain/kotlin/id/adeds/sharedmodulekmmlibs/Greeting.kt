package id.adeds.sharedmodulekmmlibs

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}