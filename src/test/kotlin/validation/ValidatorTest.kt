package validation

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.validation.CheckNumberLength
import org.example.validation.CheckStringException
import org.example.validation.Validator


class ValidatorTest : BehaviorSpec({
    Given("getValid to CheckStringException") {

        When("execute to CheckString") {
            val result = Validator().getValid(CheckStringException(), "123")

            then("return true") {
                result shouldBe true
            }
        }
    }

    Given("getValid to CheckStringException in zero") {

        When("execute to CheckString") {
            val result = Validator().getValid(CheckStringException(), "023")

            then("return true") {
                result shouldBe false
            }
        }
    }

    Given("getValid in NumberFormatException") {

        When("execute to CheckString") {
            val result = Validator().getValid(CheckStringException(), "a45")

            then("return true") {
                result shouldBe false
            }
        }
    }

    Given("getValid in CheckNumberLength String LengthException") {

        When("execute to CheckString") {
            val result = Validator().getValid(CheckNumberLength(), "1455")

            then("return false") {

                result shouldBe false
            }
        }
    }

    Given("getValid in CheckNumberLength") {

        When("execute to CheckString") {
            val result = Validator().getValid(CheckNumberLength(), "145")

            then("return false") {

                result shouldBe true
            }
        }
    }

})