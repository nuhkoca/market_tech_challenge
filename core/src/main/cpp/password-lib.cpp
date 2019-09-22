#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_techchallenge_core_util_config_SensitiveData_password(JNIEnv *env, jobject object) {
    std::string password = "2019ADev";
    return env->NewStringUTF(password.c_str());
}
