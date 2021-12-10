package org.apache.logging.log4j.core.lookup;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;

@Plugin(name = "jndi", category = "Lookup")
public class JndiLookup implements StrLookup {
    
    @Override
    public String lookup(final String key) {
        return "(Disabled JNDI Lookup with key: " + key + ")";
    }

    @Override
    public String lookup(final LogEvent event, final String key) {
        return "(Disabled JNDI Lookup with key: " + key + ")";
    }
}
