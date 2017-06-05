package com.team1.bb.core.embeddable;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by sdebnath on 4/30/17.
 */
@Embeddable
public class CommonFields {

    @Column(nullable = false)
    private final DateTime created = DateTime.now();

    @Column(nullable = false)
    private DateTime updated = DateTime.now();

    @Column(name = "created_by_id", nullable = false)
    private Long createdById;

    @Column(name = "updated_by_id", nullable = false)
    private Long updatedById;

    public DateTime getCreated() {
        return created;
    }

    public DateTime getUpdated() {
        return updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public Long getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(Long updatedById) {
        this.updatedById = updatedById;
    }

    public CommonFields withUpdated(final DateTime updated) {
        setUpdated(updated);
        return this;
    }

    public CommonFields withCreatedById(final Long createdById) {
        setCreatedById(createdById);
        return this;
    }

    public CommonFields withUpdatedById(final Long updatedById) {
        setUpdatedById(updatedById);
        return this;
    }


    @Override
    public String toString() {
        return "CommonFields{" +
            "created=" + created +
            ", updated=" + updated +
            ", createdById=" + createdById +
            ", UpdatedById=" + updatedById +
            '}';
    }
}
