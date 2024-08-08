import React from 'react';
import { Button, Card, CardContent, Typography, Divider, Grid } from '@mui/material';
import { useCart } from '../context/CartContext';
import { useNavigate } from 'react-router-dom';

const Cart = () => {
    const { cartItems, clearCart } = useCart();
    const navigate = useNavigate();

    const handleCheckout = () => {
        navigate('/checkout');
    };

    const groupedItems = cartItems.reduce((acc, item) => {
        if (acc[item.name]) {
            acc[item.name].quantity += 1;
        } else {
            acc[item.name] = { ...item, quantity: 1 };
        }
        return acc;
    }, {});

    const groupedItemsArray = Object.values(groupedItems);

    const calculateTotalPrice = () => {
        return cartItems.reduce((total, item) => total + item.price, 0).toFixed(2);
    };

    return (
        <div style={{ padding: '2rem', maxWidth: '1200px', margin: '0 auto' }}>
            <Typography variant="h4" gutterBottom align="center">Shopping Cart</Typography>
            {cartItems.length === 0 ? (
                <Typography variant="body1" align="center">Your cart is empty</Typography>
            ) : (
                <Grid container spacing={3}>
                    {groupedItemsArray.map((item, index) => (
                        <Grid item xs={12} sm={6} md={4} lg={3} key={index}>
                            <Card style={{ display: 'flex', flexDirection: 'column', height: '100%', boxShadow: '0px 2px 5px rgba(0, 0, 0, 0.1)' }}>
                                <CardContent style={{ flexGrow: 1 }}>
                                    <Typography variant="h5" gutterBottom>{item.name}</Typography>
                                    <Typography variant="body2" color="textSecondary" paragraph>
                                        Category: {item.category}
                                    </Typography>
                                    <Typography variant="body2" color="textSecondary" paragraph>{item.description}</Typography>
                                    <Typography variant="h6" color="primary">${item.price.toFixed(2)}</Typography>
                                    {item.quantity > 1 && (
                                        <Typography variant="body2" color="textSecondary">
                                            Quantity: {item.quantity}
                                        </Typography>
                                    )}
                                </CardContent>
                            </Card>
                        </Grid>
                    ))}
                </Grid>
            )}
            <Divider style={{ margin: '2rem 0' }} />
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '1rem' }}>
                <Typography variant="h6">Total Price: ${calculateTotalPrice()}</Typography>
                <div>
                    <Button variant="outlined" color="error" onClick={clearCart} style={{ marginRight: '1rem' }}>
                        Clear Cart
                    </Button>
                    <Button variant="contained" color="primary" onClick={handleCheckout}>
                        Checkout
                    </Button>
                </div>
            </div>
        </div>
    );
};

export default Cart;
