package actions.Webstorm;

import actions.selenium.SetReactModal

class SetInviteUserToTeamModalOnParticipantsPage{
    public void run(def params){
        if(params."Select project"){
        	SetReactModal.setModalRadioButtonWithInput("Section xPath":"//DIV[contains(@class,'f-participant-invite-user-modal-body')]", Title:params."Select project")
        }
        SetReactModal.setModalActionButton("Modal xPath":"//DIV[contains(@class,'f-participant-invite-user-modal-body')]/../..",Action:params."Action")
    }
}