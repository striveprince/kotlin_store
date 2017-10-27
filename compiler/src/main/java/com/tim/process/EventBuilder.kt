package com.tim.process

import com.squareup.kotlinpoet.*
import com.tim.Event
import com.tim.store.Dispatcher
import com.tim.store.Params
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic
import javax.tools.StandardLocation

/**
 * Created by pc on 2017/10/24.
 */
class EventBuilder(private val typeElement: TypeElement, private val methodElement: List<EventMethod>) {
    private val packageName by lazy { mElements.getPackageOf(typeElement).qualifiedName.toString() }
    private val fullName by lazy { typeElement.qualifiedName.toString() }
    private val classEventName by lazy { "${className}Event" }
    private val className by lazy {
        var name = fullName.substring(packageName.length + 1)
        val index = name.indexOf(".")
        if (index > 0) name = name.substring(index + 1, name.length)
        name
    }


    fun brewKotlin() {
        mMessage.printMessage(Diagnostic.Kind.WARNING, "process_start")
        val fileSpec = FileSpec.builder(packageName, classEventName)
                .addType(TypeSpec.objectBuilder(classEventName)
                        .addFunction(registerFunction())
                        .addFunctions(eventFunction(methodElement))
                        .addProperties(addEventProperty(methodElement))
                        .addProperty(addGroupProperty())
                        .build())
                .build()
        mFiler.createResource(StandardLocation.SOURCE_OUTPUT, packageName, classEventName + ".kt")
                .openWriter()
                .use { fileSpec.writeTo(it) }
        mMessage.printMessage(Diagnostic.Kind.WARNING, "process_end")
    }

    private fun addGroupProperty(): PropertySpec {
        return PropertySpec.builder("group", String::class.asTypeName())
                .initializer("\"$className\"")
                .build()
    }

    private fun addEventProperty(methodElement: List<EventMethod>): Iterable<PropertySpec> {
        return methodElement.map {
            PropertySpec.builder(it.methodName, String::class.asTypeName())
                    .initializer("\"${it.methodName}\"")
                    .build()
        }
    }

    private fun eventFunction(methodElement: List<EventMethod>): Iterable<FunSpec> {
        return methodElement.map { event ->
            FunSpec.builder("${event.methodName}Event")
                    .returns(Params::class.asTypeName())
                    .addParameters(eventParameter(event))
                    .addCode(paramCode(event))
                    .build()
        }
    }

    private fun paramCode(event: EventMethod): CodeBlock {
        val builder = StringBuilder("return %T(group,")
        builder.append(event.methodName)
        builder.append(",group,")
        event.parameters.forEach{
            builder.append(it.simpleName)
            builder.append(",")
        }
        builder.deleteCharAt(builder.lastIndex)
        builder.append(")")
        return CodeBlock.builder()
                .add(builder.toString(), Params::class.asClassName())
                .build()
    }


    private fun eventParameter(event: EventMethod): Iterable<ParameterSpec> {
        return event.parameters.map { ParameterSpec.builder(it.simpleName.toString(), it.asType().asTypeName()).build() }
    }

    private fun registerFunction(): FunSpec {
        return FunSpec
                .builder("register")
                .addParameter(className.toLowerCase(), typeElement.asClassName())
                .addModifiers(KModifier.PUBLIC)
                .addCode(CodeBlock.builder()
                        .add("%T.instance.register(group,${className.toLowerCase()})", Dispatcher::class.asClassName())
                        .build())
                .build()
    }


}