package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SubscriberFavorite generated by hbm2java
 */
@Entity
@Table(name = "SUBSCRIBER_FAVORITE", uniqueConstraints = @UniqueConstraint(columnNames = {
		"SUBSCRIBERID", "FAVORITECATEGORYID", "FAVORITEVALUE" }))
public class SubscriberFavorite extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_Subscriber = "subscriber";
	public static final String FieldName_FavoriteCategory = "favoriteCategory";
	public static final String FieldName_FavoriteLabel = "favoritelabel";
	public static final String FieldName_FavoriteValue = "favoritevalue";
	private FavoriteCategory favoriteCategory;
	private Subscriber subscriber;
	private String favoritelabel;
	private String favoritevalue;
	private String favoritecode;

	private Long id;
	
	public SubscriberFavorite() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "subscriber_favorite_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAVORITECATEGORYID", nullable = false)
	public FavoriteCategory getFavoriteCategory() {
		return this.favoriteCategory;
	}

	public void setFavoriteCategory(FavoriteCategory favoriteCategory) {
		this.favoriteCategory = favoriteCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBSCRIBERID", nullable = false)
	public Subscriber getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	

	@Column(name = "FAVORITELABEL", nullable = false)
	public String getFavoritelabel() {
		return this.favoritelabel;
	}

	public void setFavoritelabel(String favoritelabel) {
		this.favoritelabel = favoritelabel;
	}

	@Column(name = "FAVORITEVALUE", nullable = false)
	public String getFavoritevalue() {
		return this.favoritevalue;
	}

	public void setFavoritevalue(String favoritevalue) {
		this.favoritevalue = favoritevalue;
	}

	@Column(name = "FAVORITECODE", length = 45)
	public String getFavoritecode() {
		return this.favoritecode;
	}

	public void setFavoritecode(String favoritecode) {
		this.favoritecode = favoritecode;
	}

}
