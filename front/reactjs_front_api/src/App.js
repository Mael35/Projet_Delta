import './App.css';
import { useEffect, useState } from 'react';

import Header from './components/Header';
import Footer from './components/Footer';

import NewCategory from './components/newCategory/NewCategory';
import './components/newCategory/newcategory.css';

import Articles from './components/Article/Article';
import './components/Article/article.css';

import NewArticle from './components/newArticle/NewArticle';
import './components/newArticle/newarticle.css';


function App() {

  // Categories constantes

  const [allCategories, setAllCategories] = useState([
    {
      name: "Toutes les categories",
    },

    {
      name: "categoryName1",
    },

    {
      name: "categoryName2",
    },

    {
      name: "categoryName3",
    }
  ]);

  const [allArticles, setAllArticles] = useState([
    {
      category: "categoryName1",
      author: "auteur 1",
      date: "16/03/22",
      //content: "BLABLA 1",
      content: "BLABLA 1 : Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    },

    {
      category: "categoryName2",
      author: "auteur 2",
      date: "17/03/22",
      content: "BLABLA 2",
    },

    {
      category: "categoryName1",
      author: "auteur 3",
      date: "17/03/22",
      content: "BLABLA 3",
    },

    {
      category: "categoryName3",
      author: "auteur 4",
      date: "18/03/22",
      content: "BLABLA 4",
    },

    {
      category: "categoryName1",
      author: "auteur 5",
      date: "18/03/22",
      content: "BLABLA 5",
    },

    {
      category: "categoryName3",
      author: "auteur 6",
      date: "19/03/22",
      content: "BLABLA 6",
    }
  ]);
  
  const [newCategory, setNewCategory] = useState({
    categoryName: "",
  });

  const [newArticle, setNewArticle] = useState({
    articleName: "",
  });

  const [postingCategory, setPostingCategory] = useState(false);
  const [postingArticle, setPostingArticle] = useState(false);

  const [inputInvalid, setInputInvalid] = useState(false);
  
  useEffect(() => {
    fetch('http://localhost:8080/api/private/category')
    .then(res => res.json())
    .then(data => {
      setAllCategories(data);
    })
    .catch(e => console.log(e.toString()));
  }, [postingCategory]);

  useEffect(() => {
    fetch('http://localhost:8080/api/private/article')
    .then(res => res.json())
    .then(data => {
      setAllArticles(data);
    })
    .catch(e => console.log(e.toString()));
  }, [postingArticle]);
  
  function initInvalidInput() {
    setInputInvalid(false);
  }

  function isString( value){
    return value.match(/^.*[<>/\\].*$/);
  }

  function submitCategory() {
    setPostingCategory(true);
  }

  function submitArticle() {
    setPostingArticle(true);
  }

  function newCategoryChange(event) {
    const {name, value} = event.target;
    isString(value) ?
        setInputInvalid("Vous ne pouvez pas inserer de caracteres speciaux") 
        :
        value.length > 255 ?
            setInputInvalid("Le nombre maximum est de 255 caractere")
            :
            setNewCategory(prevState => {
            initInvalidInput();

            return {...prevState,
                [name]: value
            }
            });
  }

  function newArticleChange(event) {
    const {name, value} = event.target;
    isString(value) ?
        setInputInvalid("Vous ne pouvez pas inserer de caracteres speciaux") 
        :
        value.length > 255 ?
            setInputInvalid("Le nombre maximum est de 255 caractere")
            :
            setNewArticle(prevState => {
            initInvalidInput();

            return {...prevState,
                [name]: value
            }
            });
  }

  useEffect(() =>{
    if (postingCategory) {
      
      fetch('http://localhost:8080/api/private/category', {
          method: "POST",
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(newCategory)
      })
      .then(res => res.json())
      .then(data => {
        console.log(data);
        setPostingCategory(false);
        setNewCategory(prevState => {
          initInvalidInput();

          return {...prevState,
              id: -1,
              categoryName: ""
          }
          });
      })
      .catch(e => console.log(e.toString()));
    }
  }, [postingCategory]);

  useEffect(() =>{
    if (postingArticle) {
      
      fetch('http://localhost:8080/api/private/article', {
          method: "POST",
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(newArticle)
      })
      .then(res => res.json())
      .then(data => {
        console.log(data);
        setPostingArticle(false);
        setNewArticle(prevState => {
          initInvalidInput();

          return {...prevState,
              id: -1,
              categoryName: ""
          }
          });
      })
      .catch(e => console.log(e.toString()));
    }
  }, [postingArticle]);
  
  /*
        <Category
          data={allCategories}
        />
  */
  return (
    <div className="App">
      
      <Header />

      <main>

        <Articles
          dataC={allCategories}
          dataA={allArticles}
        />
        
        <div className="Ajouts">
          <NewCategory 
            newCategory={newCategory}
            newCategoryChange={newCategoryChange}
            submitCategory={submitCategory}
            inputInvalid={inputInvalid} 
          />

          <NewArticle 
            newArticle={newArticle}
            newArticleChange={newArticleChange}
            submitArticle={submitArticle}
            inputInvalid={inputInvalid} 
          />
        </div>
      </main>

      <Footer />

    </div>
  );
}

export default App;
