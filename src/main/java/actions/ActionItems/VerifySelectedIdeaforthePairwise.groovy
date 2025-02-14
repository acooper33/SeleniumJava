package actions.ActionItems;

import actions.selenium.Exists

class VerifySelectedIdeaforthePairwise{
    public void run(def params){

        params."Pairing".split(",").eachWithIndex{ name, x ->
            def idea  = params."Selected Idea".split(",")
            assert Exists.run(ID:"//*[@id='pairing_column' and contains(.,'${name}')]/..//*[@id='selected_column' and contains(.,'${idea[x]}')]")>0, "Error - ${idea[x]} is the not the selected idea for ${name}"
        } 
    }
}
