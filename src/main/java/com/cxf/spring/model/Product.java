package com.cxf.spring.model;

public class Product {

    private String id;
    private String name;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
     * Don't use getXXX else It will be picked up in Json response.
     */
    public String XmlFormat() {
        StringBuffer sb = new StringBuffer();
        sb.append("<product>").append("<id>" + id + "</id>").append("<name>" + name + "</name>")
                .append("<type>" + type + "</type>").append("</product>");
        return sb.toString();
    }

}
