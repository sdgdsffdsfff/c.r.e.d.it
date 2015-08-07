package com.ctc.credit.common;

import net.sf.json.JSONException;
import net.sf.json.util.PropertySetStrategy;

public class PropertyStrategyWrapper extends PropertySetStrategy {

private PropertySetStrategy original;
    
    public PropertyStrategyWrapper(PropertySetStrategy original) {
        this.original = original;
    }

    @Override
    public void setProperty(Object o, String string, Object o1) throws JSONException {
        try {
            original.setProperty(o, string, o1);
        } catch (Exception ex) {
        }
    }
}
