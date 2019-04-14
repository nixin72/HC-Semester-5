using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HeritageBookStore.Controllers {
	public class BookController : Controller {
		List<Models.Book> bookList = Models.BookList.Instance.GetList();

		// GET: Book
		public ActionResult Index() {
			return View(bookList);
		}

		// GET: Book/Details/5
		public ActionResult Details(int id) {
			return View(bookList.Find(b => b.BookID == id));
		}

		// GET: Book/Create
		public ActionResult Create() {
			return View();
		}

		// POST: Book/Create
		[HttpPost]
		public ActionResult Create(FormCollection collection) {
			try {
				Models.Book newBook = new Models.Book() {
					BookAuthor = collection["BookAuthor"],
					BookCategory = collection["BookCategory"],
					BookCover = collection["BookCover"],
					BookLanguage = collection["BookLanguage"],
					BookYear = Int16.Parse(collection["BookYear"]),
					BookPrice = Int16.Parse(collection["BookPrice"]),
					BookTitle = collection["BookTitle"]
				};

				Models.BookList.Instance.addBook(newBook);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}

		// GET: Book/Edit/5
		public ActionResult Edit(int id) {
			return View(bookList.Find(b => b.BookID == id));
		}

		// POST: Book/Edit/5
		[HttpPost]
		public ActionResult Edit(int id, FormCollection collection) {
			try {
				Models.Book newBook = new Models.Book() {
					BookAuthor = collection["BookAuthor"],
					BookCategory = collection["BookCategory"],
					BookCover = collection["BookCover"],
					BookLanguage = collection["BookLanguage"],
					BookYear = Int16.Parse(collection["BookYear"]),
					BookPrice = Int16.Parse(collection["BookPrice"]),
					BookTitle = collection["BookTitle"],
					BookID = Int16.Parse(collection["BookID"])
				};

				Models.BookList.Instance.editBook(id, newBook);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}

		// GET: Book/Delete/5
		public ActionResult Delete(int id) {
			return View(bookList.Find(b => b.BookID == id));
		}

		// POST: Book/Delete/5
		[HttpPost]
		public ActionResult Delete(int id, FormCollection collection) {
			try {
				Models.BookList.Instance.removeBook(id);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}
	}
}
