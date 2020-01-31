
tasks {
    register<Task>("broken") {
        val prop = objects.property(String::class.java)
        prop.set(provider { 
            "abc"
        })
        doLast {
            println("-> value = ${prop.get()}")
        }
    }
    register<Task>("ok1") {
        val prop = objects.property(String::class.java)
        val function = { "abc" }
        prop.set(provider(function))
        doLast {
            println("-> value = ${prop.get()}")
        }
    }
}

tasks.register<Task>("ok2") {
    val prop = objects.property(String::class.java)
    prop.set(provider { 
        "abc"
    })
    doLast {
        println("-> value = ${prop.get()}")
    }
}
