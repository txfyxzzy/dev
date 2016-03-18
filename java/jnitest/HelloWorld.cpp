#include <jni.h>
//#include "com_magc_jni_HelloWorld.h"
#include <stdio.h>
extern "C" JNIEXPORT void JNICALL Java_HelloWorld_DisplayHello
(JNIEnv *env, jobject obj)
{
    printf("From jni_helloworldImpl.cpp :");
    printf("Hello world ! \n");
    return;
}
