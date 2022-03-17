import './App.css';
import { useEffect, useState } from 'react';

import Header from './components/Header';
import Footer from './components/Footer';

import Category from './components/Category/Category';
import './components/Category/category.css';

import NewCategory from './components/newCategory/NewCategory';
import './components/newCategory/newcategory.css';


function App() {

  const [allCategories, setAllCategories] = useState([
    {
      id: 1,
      name: "Categorie à selectionner",
    },

    {
      id: 2,
      name: "categoryName1",
    },

    {
      id: 3,
      name: "categoryName2",
    }
  ]);
  
  const [newCategory, setNewCategory] = useState({
    categoryName: "",
  });

  const [postingCategory, setPostingCategory] = useState(false);
  const [inputInvalid, setInputInvalid] = useState(false);
  
  useEffect(() => {
    fetch('http://localhost:8080/api/private/category')
    .then(res => res.json())
    .then(data => {
      setAllCategories(data);
    })
    .catch(e => console.log(e.toString()));
  }, [postingCategory]);
  
  function initInvalidInput() {
    setInputInvalid(false);
  }

  function isString( value){
    return value.match(/^.*[<>/\\].*$/);
  }

  function submitCategory() {
    setPostingCategory(true);
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
                id: allCategories.length + 1,
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
  
  return (
    <div className="App">
      
      <Header />

      <main>
        <Category
          data={allCategories}
        />
        
        <NewCategory 
          newCategory={newCategory}
          newCategoryChange={newCategoryChange}
          submitCategory={submitCategory}
          inputInvalid={inputInvalid} 
        />
      </main>

      <Footer />

    </div>
  );
}

export default App;
