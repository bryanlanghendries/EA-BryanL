import React, { useEffect } from 'react';
import { Typography, Button, Container, Paper } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { useCart } from '../context/CartContext';

const Checkout = () => {
    const navigate = useNavigate();
    const { clearCart } = useCart();

    useEffect(() => {
        clearCart();
    }, [clearCart]);

    const handleGoHome = () => {
        navigate('/');
    };

    return (
        <Container style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'start', minHeight: '100vh', padding: '2rem' }}>
            <Paper elevation={3} style={{ padding: '2rem', textAlign: 'center', maxWidth: '600px', width: '100%' }}>
                <Typography variant="h4" gutterBottom color="primary">Thank You for Your Purchase!</Typography>
                <Typography variant="body1" paragraph>
                    Your order has been confirmed. We will process it shortly. If you have any questions, feel free to contact our support team.
                </Typography>
                <Button variant="contained" color="primary" onClick={handleGoHome} style={{ marginTop: '1rem' }}>
                    Go to Home
                </Button>
            </Paper>
        </Container>
    );
};

export default Checkout;
