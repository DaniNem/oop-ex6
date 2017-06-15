package oop.ex6.main;

/**
 * Created by Admin on 15-Jun-17.
 */
public class ValidatorResult {
    private String variableType,variableValue,variableName,functionName,functionType,errorString;
    private boolean hasError,isNewScope,isScopeClosed,hasReturn;

    public boolean isHasError() {
        return hasError;
    }

    public boolean isHasReturn() {
        return hasReturn;
    }

    public boolean isNewScope() {
        return isNewScope;
    }

    public boolean isScopeClosed() {
        return isScopeClosed;
    }

    public String getErrorString() {
        return errorString;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getFunctionType() {
        return functionType;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getVariableType() {
        return variableType;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public void setHasReturn(boolean hasReturn) {
        this.hasReturn = hasReturn;
    }

    public void setNewScope(boolean newScope) {
        isNewScope = newScope;
    }

    public void setScopeClosed(boolean scopeClosed) {
        isScopeClosed = scopeClosed;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }
}
