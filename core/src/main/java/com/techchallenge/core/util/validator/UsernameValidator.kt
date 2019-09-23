package com.techchallenge.core.util.validator

import com.techchallenge.core.util.config.SensitiveData
import javax.inject.Inject

class UsernameValidator @Inject constructor() : Validator<String> {

    override fun isValid(input: String) =
        input.isNotEmpty() && input == SensitiveData.username()
}
