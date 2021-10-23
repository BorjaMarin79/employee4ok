package example.boot.dev.shop;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

	
	
	public class OrderService {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private Date date;
		private int qty;
		private String deliveryType;
		private boolean done;
		
		
		
		
		@ManyToOne
		@JoinColumn(name = "FID_USER")
		private User user;
		
		public OrderService() {
			super();
		}

		public OrderService(int id, Date date, int qty, String deliveryType, boolean done, User user) {
			super();
			this.id = id;
			this.date = date;
			this.qty = qty;
			this.deliveryType = deliveryType;
			this.done = done;
			this.user = user;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public String getDeliveryType() {
			return deliveryType;
		}

		public void setDeliveryType(String deliveryType) {
			this.deliveryType = deliveryType;
		}

		public boolean isDone() {
			return done;
		}

		public void setDone(boolean done) {
			this.done = done;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "OrderService [id=" + id + ", date=" + date + ", qty=" + qty + ", deliveryType=" + deliveryType
					+ ", done=" + done + ", user=" + user + "]";
		}
		
		

}
