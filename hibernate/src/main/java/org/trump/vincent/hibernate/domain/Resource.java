package org.trump.vincent.hibernate.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Vincent on 2018/1/23 0023.
 */
public class Resource implements Serializable{
    private static final long serialVersionUID = 42321L;

    protected String id;

    protected String name;
    protected String ccid;
    protected String parentId;
    protected String rootId;
    protected Timestamp created;
    protected int inpoint;
    protected int outpoint;
    protected String iconFile = "";
    protected Timestamp lastModify;
    protected int priority;
    protected int hasFile;

    public long getVersion() {
        return version;
    }

    public Resource setVersion(long version) {
        this.version = version;
        return this;
    }

    private long version;

    public String getId() {
        return id;
    }

    public Resource setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Resource setName(String name) {
        this.name = name;
        return this;
    }

    public String getCcid() {
        return ccid;
    }

    public Resource setCcid(String ccid) {
        this.ccid = ccid;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Resource setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getRootId() {
        return rootId;
    }

    public Resource setRootId(String rootId) {
        this.rootId = rootId;
        return this;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Resource setCreated(Timestamp created) {
        this.created = created;
        return this;
    }

    public int getInpoint() {
        return inpoint;
    }

    public Resource setInpoint(int inpoint) {
        this.inpoint = inpoint;
        return this;
    }

    public int getOutpoint() {
        return outpoint;
    }

    public Resource setOutpoint(int outpoint) {
        this.outpoint = outpoint;
        return this;
    }

    public String getIconFile() {
        return iconFile;
    }

    public Resource setIconFile(String iconFile) {
        this.iconFile = iconFile;
        return this;
    }

    public Timestamp getLastModify() {
        return lastModify;
    }

    public Resource setLastModify(Timestamp lastModify) {
        this.lastModify = lastModify;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public Resource setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public int getHasFile() {
        return hasFile;
    }

    public Resource setHasFile(int hasFile) {
        this.hasFile = hasFile;
        return this;
    }
}
