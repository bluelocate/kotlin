package inlineInIfFalseDex

fun inlineIfFalse() {
    val bar = ""
    //Breakpoint!
    if (inlineCall { true }) {
        foo()
    }
    foo()
}

fun foo() {}

inline fun inlineCall(predicate: (String?) -> Boolean): Boolean {
    return false
}

// 0 LINENUMBER 7
// 0 LINENUMBER 8
// 1 LINENUMBER 9

// Not actually inlined, so there is a LINENUMBER 7 because the if's body is not considered dead.
// IGNORE_BACKEND: JVM_IR
