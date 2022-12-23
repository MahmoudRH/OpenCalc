package com.darkempire78.opencalculator

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AppUnitTests::class,
    ParameterizedTests::class
)
class SuiteTest
