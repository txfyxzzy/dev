//必须的头文件jni.h
#include <jni.h>
//导入我们需要实现的本地方法
#include "MyJni.h"
#include <stdio.h>
 
JNIEXPORT void JNICALL Java_MyJni_display
  (JNIEnv *env, jobject obj)
{
    printf("Hello World tom!!");
    return;
}
 
JNIEXPORT jdouble JNICALL Java_MyJni_sum
  (JNIEnv *env, jobject obj, jdouble a, jdouble b)
{
    return a + b;
}
