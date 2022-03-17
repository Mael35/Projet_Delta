import 'bootstrap/dist/css/bootstrap.css';
import { Form } from "react-bootstrap";
import React, { useState } from "react";

export default function Category(props) {
    const [val, setVal] = useState();

    return (
        <div className="category">
            <Form.Select value={val} onChange={(e) => setVal(e.target.value)}>
                {props.data.map((o) => {
                    const { id, name } = o;
                    return <option value={id}>{name}</option>;
                })}
            </Form.Select>
        </div>
    )
}