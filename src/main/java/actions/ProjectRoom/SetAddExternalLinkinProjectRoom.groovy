package actions.ProjectRoom;

import actions.selenium.SetReactModal

class SetAddExternalLinkinProjectRoom {
    public void run(def params){
        SetReactModal.setModalWithOneInputField("Order Num":"1", "Text":params."Link Name")
        SetReactModal.setModalWithOneInputField("Order Num":"2", "Text":params."Link URL")
        sleep(1000)
        SetReactModal.setModalActionButton(params)
    }
}