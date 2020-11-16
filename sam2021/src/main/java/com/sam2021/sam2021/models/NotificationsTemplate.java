package com.sam2021.sam2021.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sam2021.sam2021.models.Enums.NotificationTypeEnum;
import com.sam2021.sam2021.models.Enums.TriggerEnum;


@Entity
@Table(name = "NotificationsTemplate")
public class NotificationsTemplate {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
	private String message;
	
	@Enumerated(EnumType.STRING)
	private NotificationTypeEnum accountType;
	
	@Enumerated(EnumType.STRING)
	private TriggerEnum triggerEnum;

	// @Enumerated(EnumType.STRING)
	// private userinterestEnum userinter;

	@OneToMany( mappedBy = "nTemplate", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<User> interested_users;

	public NotificationsTemplate(String message, NotificationTypeEnum accountType, TriggerEnum triggerEnum) {
		this.message = message;
		this.accountType = accountType;
		this.triggerEnum = triggerEnum;
	}

	//Getter
	public NotificationTypeEnum getAccountType() {
		return accountType;
	}
	public Long getId() {
		return id;
	}
	public Set<User> getInterested_users() {
		return interested_users;
	}
	public String getMessage() {
		return message;
	}
	public TriggerEnum getTriggerEnum() {
		return triggerEnum;
	}

	//Setter
	public void setAccountType(NotificationTypeEnum accountType) {
		this.accountType = accountType;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setInterested_users(Set<User> interested_users) {
		this.interested_users = interested_users;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTriggerEnum(TriggerEnum triggerEnum) {
		this.triggerEnum = triggerEnum;
	}
    
    
	
}
