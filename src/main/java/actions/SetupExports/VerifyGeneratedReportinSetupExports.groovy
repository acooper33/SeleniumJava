package actions.SetupExports;

import actions.selenium.Exists
import actions.selenium.utils.*

class VerifyGeneratedReportinSetupExports{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[contains(@class, 'report-name') and starts-with(text(), '${params."Report Name Starts with"}')]"
        if (params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}