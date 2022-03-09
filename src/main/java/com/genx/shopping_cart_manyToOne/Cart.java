package com.genx.shopping_cart_manyToOne;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="Cart")
public class Cart {
	@Id
	private int cartId;
	
	@OneToMany
	@JoinColumn(name="Items_In_Cart")
	private List<Items> items;
}
