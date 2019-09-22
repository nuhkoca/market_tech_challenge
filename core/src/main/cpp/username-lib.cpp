#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_techchallenge_core_util_config_SensitiveData_username(JNIEnv *env, jobject object) {
    std::string username = "kariyer";
    return env->NewStringUTF(username.c_str());
}
