import 'bootstrap/dist/css/bootstrap.css';
import { Form } from "react-bootstrap";
import { useState } from 'react';

export default function Articles(props) {

    const articlesElements = props.dataA.map(i => 
        <div key={i.id} className="articles__item" >
        <h3 className="article__category">{i.category}</h3>
        <h3 className="article__authorName">{i.author}</h3>
        <h3 className="article__date">{i.date}</h3>
        <h3 className="article__content">{i.content}</h3>
    </div>);
    
    const [val, setVal] = useState("Toutes les categories");

    return (
        <div className="body">
            <div className="category">
                <h3 className='category__title'>Categorie à selectionner</h3>
                <Form.Select
                    value={val} 
                    onChange={(e) => setVal(e.target.value)}
                >
                    {props.dataC.map((o) => {
                        const { name } = o;
                        return <option value={name}>{name}</option>;
                    })}
                    
                </Form.Select>
                
                <div className="articles">
                    <h2 className='articles__title'>Articles</h2>
                    <div className='articles__container'>
                        {
                            val === "Toutes les categories" ?
                                <div className='articles__container'>{articlesElements}</div>
                            :
                            props.dataA.map(i =>
                            {
                                return i.category === val ?
                                    <div key={i.id} className="articles__item" >
                                        <h3 className="article__category">{i.category}</h3>
                                        <h3 className="article__authorName">{i.author}</h3>
                                        <h3 className="article__date">{i.date}</h3>
                                        <h3 className="article__content">{i.content}</h3>
                                    </div>
                                :
                                null
                            })
                        }
                    </div>
                </div>
            </div>
        </div>
    )
}