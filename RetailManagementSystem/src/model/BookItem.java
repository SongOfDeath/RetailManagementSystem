package model;

public class BookItem extends Item{
	
	String author;
	int isbn;
	String publisher;
	String copyrights;
	
	public BookItem(String name, int barcode, double price, String author, int isbn, String publisher, String copyrights, int discount) {
		super(name, barcode, price, discount);
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.copyrights = copyrights;
	}
	
	@Override
	public String returnItemData()
	{
		String s = name + "-" + barcode + "-" + price + "-" + author + "-" + isbn + "-" + publisher + "-" + copyrights;
		return s;
	}

	@Override
	public String toString() {
		return "BookItem [author=" + author + ", isbn=" + isbn + ", publisher=" + publisher + ", copyrights="
				+ copyrights + ", name=" + name + ", barcode=" + barcode + ", price=" + price + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCopyrights() {
		return copyrights;
	}

	public void setCopyrights(String copyrights) {
		this.copyrights = copyrights;
	}
	
}
