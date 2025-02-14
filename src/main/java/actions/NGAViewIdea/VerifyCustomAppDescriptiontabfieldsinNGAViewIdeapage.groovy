package actions.NGAViewIdea;

import actions.common.*
import actions.NGAViewIdea.*

class VerifyCustomAppDescriptiontabfieldsinNGAViewIdeapage{
    public void run(def params){
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Multiple Choice Question","Field Value":params."Multiple Choice Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Checkbox Question","Field Value":params."Checkbox Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Short Answer Question","Field Value":params."Short Answer Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Long Answer Question","Field Value":params."Long Answer Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Dropdown Question","Field Value":params."Dropdown Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Date Question","Field Value":params."Date Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Number Question","Field Value":params."Number Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"User Selection Question","Field Value":params."User Selection Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Admin Only Dropdown Question","Field Value":params."Admin Only Dropdown Question"])
        VerifyNGAViewIdeaDescriptionTabFieldValue.run(["Field Name":"Required Short Question","Field Value":params."Required Short Question"])
    }
}