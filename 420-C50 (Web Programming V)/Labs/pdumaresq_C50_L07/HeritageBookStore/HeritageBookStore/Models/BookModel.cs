using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Xml;

namespace HeritageBookStore.Models {
	public class Book {
		public Int16 BookID { get; set; }
		public String BookCategory { get; set; }
		public String BookCover { get; set; }
		public String BookTitle { get; set; }
		public String BookLanguage { get; set; }
		public String BookAuthor { get; set; }
		public Int16 BookYear { get; set; }
		public Double BookPrice { get; set; }
	}

	public class BookList {
		List<Book> Books;
		private static BookList instance = null;

		private BookList() {
			Books = null;
		}

		public void editBook(int id, Book newBook) {
			Books.Find(b => b.BookID == newBook.BookID).BookAuthor = newBook.BookAuthor;
			Books.Find(b => b.BookID == newBook.BookID).BookCategory = newBook.BookCategory;
			Books.Find(b => b.BookID == newBook.BookID).BookCover = newBook.BookCover;
			Books.Find(b => b.BookID == newBook.BookID).BookLanguage = newBook.BookLanguage;
			Books.Find(b => b.BookID == newBook.BookID).BookPrice = newBook.BookPrice;
			Books.Find(b => b.BookID == newBook.BookID).BookTitle = newBook.BookTitle;
			Books.Find(b => b.BookID == newBook.BookID).BookYear = newBook.BookYear;
		}

		public void removeBook(int id) {
			Books.Remove(Books.Find(b => b.BookID == id));
		}

		public void addBook(Book newBook) {
			newBook.BookID = Int16.Parse((Books.Max(b => b.BookID) + 1).ToString());
			Books.Add(newBook);
		}

		public List<Book> GetList() {
			return Books;
		}

		 
		public static BookList Instance => instance ?? (
			instance = new BookList {
				Books = new List<Book> {
					new Book() {BookAuthor = "Giada De Laurentiis", BookCategory = "Cooking", BookCover = "", BookLanguage = "en", BookYear = 2005, BookPrice = 30.00, BookTitle = "Everyday Italian", BookID = 1},
					new Book() {BookAuthor = "J K. Rowling", BookCategory = "children", BookCover = "", BookLanguage = "en", BookYear = 2005, BookPrice = 29.99, BookTitle = "Harry Potter", BookID = 2},
					new Book() {BookAuthor = "James McGovern", BookCategory = "web", BookCover = "", BookLanguage = "en", BookYear = 2003, BookPrice = 49.99, BookTitle = "XQuery Kick Start", BookID = 3},
					new Book() {BookAuthor = "Christopher Paolini", BookCategory = "fantasy", BookCover = "paperback", BookLanguage = "en", BookYear = 2008, BookPrice = 13.99, BookTitle = "Eragon", BookID = 5}
				}
			}
		);
	}
}