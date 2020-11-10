package com.sam2021.sam2021.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NotificationsTemplate")
public class NotificationsTemplate {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String templateName;

    private String filename;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "interested_users", nullable = false)
    private Set<User> interested_users;
    
    public NotificationsTemplate(String templateName, String filename) {
		this.templateName = templateName;
		this.filename = filename;
	}

	public Long getId() {
		return id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Set<User> getInterested_users() {
		return interested_users;
	}

	public void setInterested_users(Set<User> interested_users) {
		this.interested_users = interested_users;
	}
}
