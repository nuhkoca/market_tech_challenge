package com.techchallenge.marketim.ui.login

import com.techchallenge.core.util.config.SensitiveData
import com.techchallenge.core.util.validator.Validator
import javax.inject.Inject

class UsernameValidator @Inject constructor(): Validator<String> {

    override fun isValid(input: String) =
        input.isNotEmpty() && input == SensitiveData.username()
}
