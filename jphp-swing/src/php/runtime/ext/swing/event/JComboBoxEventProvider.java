package php.runtime.ext.swing.event;

import php.runtime.env.Environment;
import php.runtime.ext.swing.ComponentProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JComboBoxEventProvider extends EventProvider<JComboBox> {
    @Override
    public Class<JComboBox> getComponentClass() {
        return JComboBox.class;
    }

    @Override
    public void register(final Environment env, JComboBox component, final ComponentProperties properties) {
        component.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                triggerItem(env, properties, "changed", e);
            }
        });
    }

    @Override
    public boolean isAllowedEventType(Component component, String code) {
        return "changed".equalsIgnoreCase(code);
    }
}
