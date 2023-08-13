package actions;

import org.openapitools.client.model.Action;

public class ActionTypeFactory {

  public static ActionType getActionType(Action action) {
    if (action.getActionType().equals(Action.ActionTypeEnum.EXECUTE)) {
      return new ExecuteActionType();
    } else if (action.getActionType().equals(Action.ActionTypeEnum.PAUSE)) {
      return new PauseActionType();
    }
    return null;
  }
}
