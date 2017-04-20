const express = require('express');
const app = express();
const parser = require('body-parser').urlencoded({ extended: false });

app.listen(process.env.PORT || 3000, () => console.log('Ser started'));

app.post('/login', parser, (req, res) => {
    const { user, pass } = req.body;
    console.log(`${user} ${pass}`);
    res.send({ user, pass });
});