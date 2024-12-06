<script>
const express = require('express');
const nodemailer = require('nodemailer');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

// ตั้งค่าอีเมลเซิร์ฟเวอร์
const transporter = nodemailer.createTransport({
    service: 'gmail', // หรือ SMTP อื่น
    auth: {
        user: 'your-email@gmail.com',
        pass: 'your-email-password', // ใช้ App Password แทนถ้าคุณเปิด 2FA
    },
});

app.post('/send-email', (req, res) => {
    const { email, message } = req.body;

    const mailOptions = {
        from: 'your-email@gmail.com',
        to: 'receiver-email@example.com',
        subject: `Message from ${email}`,
        text: message,
    };

    transporter.sendMail(mailOptions, (error, info) => {
        if (error) {
            console.error(error);
            res.status(500).send('Error sending email');
        } else {
            console.log('Email sent: ' + info.response);
            res.status(200).send('Email sent successfully');
        }
    });
});

// รันเซิร์ฟเวอร์
app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
});