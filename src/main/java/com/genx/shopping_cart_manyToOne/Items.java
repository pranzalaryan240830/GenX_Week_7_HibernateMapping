package com.genx.shopping_cart_manyToOne;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Items")
public class Items {
	@Id
	private int itemId;
	
	private String itemName;
	private int itemPrice;
	
	@ManyToOne
	private Cart cart;
}
