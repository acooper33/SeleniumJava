package actions.Whiteboards;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import actions.selenium.Browser

class SendKeysToWhiteboard {
    public static void run(def params) {
        System.out.println("In Send Keys to WB");

        Actions builder = new Actions(Browser.Driver);
        //String keysToSend = params."Key(s) to send".toLowerCase();
        String keysToSend = params."Key(s) to send"

        switch (keysToSend) {
            case "Delete":
                builder.sendKeys(Keys.DELETE);
                break;
            case "Tab":
                builder.sendKeys(Keys.TAB);
                break;
            case "Enter":
                builder.sendKeys(Keys.ENTER);
                break;
            case "Up":
                builder.sendKeys(Keys.UP);
                break;
            case "Down":
                builder.sendKeys(Keys.DOWN);
                break;
            case "Left":
                builder.sendKeys(Keys.ARROW_LEFT);
                break;
            case "Right":
                builder.sendKeys(Keys.ARROW_RIGHT);
                break;
            case "Escape":
            	println("Sending Escape")
                builder.sendKeys(Keys.ESCAPE);
                break;
            case "Space":
                builder.sendKeys(Keys.SPACE);
                break;
            case "Control + Z":
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("z").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Control + F":
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("f").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Control + C":
                println("We are in Ctrl c")
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("c").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Control + V":
            println("We are in Ctrl V")
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("v").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Control + A":
                 println("We are in Ctrl a")
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Control + T":
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("t").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Control + D":
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("d").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Control + K":
                builder.keyDown(Keys.LEFT_CONTROL).sendKeys("k").keyUp(Keys.LEFT_CONTROL);
                break;
            case "Shift + Up":
                builder.keyDown(Keys.SHIFT).sendKeys(Keys.UP).keyUp(Keys.SHIFT);
                break;
            case "Shift + Down":
                builder.keyDown(Keys.SHIFT).sendKeys(Keys.DOWN).keyUp(Keys.SHIFT);
                break;
            case "Shift + Control + Left":
                builder.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT);
                break;
            case "Control + Shift + P": // for whiteboard PDF export
                builder.keyDown(Keys.LEFT_CONTROL).keyDown(Keys.SHIFT).sendKeys('p').keyUp(Keys.LEFT_CONTROL).keyUp(Keys.SHIFT);
                break;
            case "Control + Shift + E": // for whiteboard PNG export
                builder.keyDown(Keys.LEFT_CONTROL).keyDown(Keys.SHIFT).sendKeys('e').keyUp(Keys.LEFT_CONTROL).keyUp(Keys.SHIFT);
                break;
            case "Control + Shift + V": // for whiteboard PNG export
                builder.keyDown(Keys.LEFT_CONTROL).keyDown(Keys.SHIFT).sendKeys('v').keyUp(Keys.LEFT_CONTROL).keyUp(Keys.SHIFT);
                break;
            case "Control + Shift + X": // for strikethrough
                builder.keyDown(Keys.LEFT_CONTROL).keyDown(Keys.SHIFT).sendKeys('x').keyUp(Keys.LEFT_CONTROL).keyUp(Keys.SHIFT);
                break;
            case "Hold Shift":
                builder.keyDown(Keys.SHIFT);
                break;
            case "Release Shift":
                builder.keyUp(Keys.SHIFT);
                break;
            default:
                //Actions builder = new Actions(Browser.Driver)
        		//builder.moveByOffset(0,0).click().sendKeys(keysToSend)
                builder.sendKeys(keysToSend);
                System.out.println("Keys: " + keysToSend);
                break;
        }

        builder.build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
