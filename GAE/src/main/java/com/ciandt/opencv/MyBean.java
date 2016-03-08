package com.ciandt.opencv;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * test..
 *
 * @author Pedro Felipe Marques Moreira
 * @since 6 de mar de 2016
 */
public class MyBean {

    private String content;
    private String firmwareVersion;

    /**
     *
     * @author Pedro Felipe Marques Moreira
     * @since 7 de mar de 2016
     */
    public MyBean(final String content, final String firmwareVersion) {
        this.content = content;
        this.firmwareVersion = firmwareVersion;
    }

    public String getContent() {
        return content;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     *
     * @author Pedro Felipe Marques Moreira
     *
     * @since 7 de mar de 2016
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).build();
    }
}