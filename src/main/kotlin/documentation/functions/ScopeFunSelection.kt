package documentation.functions

fun main() {

    /**
     * SCOPE FUNCTION SELECTION
     *
     * Func -> Object reference -> Return Value -> Is Extension Func?
     *
     * let -> it -> lambda result -> Yes
     * run -> this -> lambda result -> Yes
     * run -> - -> lambda result -> No, called without the context object
     * with -> this -> lambda result -> No, takes the context object as an argument
     * apply -> this -> context object -> Yes
     * also -> it -> context object -> Yes
     *
     * A short guide for choosing scope functions depending on the intended purpose:
     * 1. Executing a lambda on non-null objects: let
     * 2. Introducing an expression as a variable in local scope: let
     * 3. Object configuration: apply
     * 4. Object configuration and computing the result: run
     * 5. Running statements where an expression is required: non-extension run
     * 6. Additional effects: also
     * 7. Grouping function calls on an object: with
     *
     * The use cases of different functions overlap, so that you can choose the functions
     * based on the specific conventions used in your project or team.
     * Although the scope functions are a way of making the code more concise, avoid
     * overusing them: it can decrease your code readability and lead to errors.
     * Avoid nesting scope functions and be careful when chaining them: it's easy to get
     * confused about the current context object and the value of this or it.
     */
}