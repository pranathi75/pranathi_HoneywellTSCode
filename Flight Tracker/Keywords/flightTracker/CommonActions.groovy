package flightTracker
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

class CommonActions {


	@Keyword
	def openWebsite() {
		WebUI.openBrowser('https://www.flightstats.com/v2/flight-tracker/search')
		WebUI.waitForPageLoad(10)
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/FlightTrackerHeading'), 10, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def searchByFlight() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/searchByFlight'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/airlineFieldName'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/airlineInputBox'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/SearchByFlightSection/airlineInputBox'), '6E', FailureHandling.STOP_ON_FAILURE)
		def airlineName = WebUI.getText(findTestObject('Object Repository/SearchByFlightSection/arilineName1'), FailureHandling.STOP_ON_FAILURE)
		print("Airline name is : " +airlineName)
		WebUI.click(findTestObject('Object Repository/SearchByFlightSection/arilineName1'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/flightNumberFieldName'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/flightNumberInputBox'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/SearchByFlightSection/flightNumberInputBox'), '5384', FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/dateFieldName'), 10, FailureHandling.STOP_ON_FAILURE)
		def date = WebUI.getText(findTestObject('Object Repository/SearchByFlightSection/dateFieldName'), FailureHandling.STOP_ON_FAILURE)
		print("date is :" +date)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SearchByFlightSection/searchButton'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/SearchByFlightSection/searchButton'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
	}
	@Keyword
	def verifyFlightStatusPage() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/flightDetailsPage/searchedFlightNameHeading'), 10, FailureHandling.STOP_ON_FAILURE)
		def FlightnumHeading = WebUI.getText(findTestObject('Object Repository/flightDetailsPage/searchedFlightNameHeading'), FailureHandling.STOP_ON_FAILURE)
		print("Searched Airline and flight number:" +FlightnumHeading)
		WebUI.verifyElementPresent(findTestObject('Object Repository/flightDetailsPage/fromLoc'), 10, FailureHandling.STOP_ON_FAILURE)
		def FromLocation = WebUI.getText(findTestObject('Object Repository/flightDetailsPage/fromLoc'), FailureHandling.STOP_ON_FAILURE)
		print("Searched Airline From location:" +FromLocation)
		WebUI.verifyElementPresent(findTestObject('Object Repository/flightDetailsPage/toLoc'), 10, FailureHandling.STOP_ON_FAILURE)
		def ToLocation = WebUI.getText(findTestObject('Object Repository/flightDetailsPage/toLoc'), FailureHandling.STOP_ON_FAILURE)
		print("Searched Airline To location:" +ToLocation)
		
		}
}