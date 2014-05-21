package com.petstore.taa.test.suite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.petstore.taa.test.AccountInfoUpdateTestNew;
import com.petstore.taa.test.CartUpdateTestNew;
import com.petstore.taa.test.NavigationToItemTest;
import com.petstore.taa.test.PriceVerificationMultiTest;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@SuiteClasses({AccountInfoUpdateTestNew.class, CartUpdateTestNew.class, NavigationToItemTest.class, PriceVerificationMultiTest.class})
public class FastTestSuite {

}
