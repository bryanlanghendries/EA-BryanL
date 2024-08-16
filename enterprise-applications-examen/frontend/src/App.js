import React, { useState, useEffect } from 'react';
import {BrowserRouter as Router, Route, Routes, Link, useNavigate} from 'react-router-dom';
import { AppBar, Toolbar, Typography, Button, Container, IconButton, Badge, CssBaseline } from '@mui/material';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import Catalog from './pages/Catalog';
import Home from './pages/Home';
import Cart from './pages/Cart';
import Checkout from './pages/Checkout';
import Login from './pages/Login';
import Register from './pages/Register';
import { CartProvider, useCart } from './context/CartContext';
import './App.css';

import Auth from "./middleware/Auth";

function Navbar() {
    const navigate = useNavigate();
    const { getCartItemCount } = useCart();
    const cartItemCount = getCartItemCount();

    const handleLogout = () => {
        localStorage.removeItem('authToken');
        navigate('/login');
    };

    return (
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                    Paws & Claws
                </Typography>
                <Button color="inherit" component={Link} to="/">Home</Button>
                <Button color="inherit" component={Link} to="/catalog">Catalog</Button>
                <IconButton color="inherit" component={Link} to="/cart">
                    <Badge badgeContent={cartItemCount} color="error">
                        <ShoppingCartIcon />
                    </Badge>
                </IconButton>
                {!!localStorage.getItem('authToken') && (
                    <Button
                        color="secondary"
                        variant="contained"
                        onClick={handleLogout}
                        sx={{ marginLeft: 2, backgroundColor: '#d32f2f', '&:hover': { backgroundColor: '#b71c1c' } }}
                    >
                        Logout
                    </Button>
                )}
            </Toolbar>
        </AppBar>
    );
}

function App() {
    return (
        <CartProvider>
            <Router>
                <CssBaseline />
                <Navbar />
                <Container sx={{ marginTop: 2 }}>
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/register" element={<Register />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/catalog" element={<Auth Component={<Catalog />} />} />
                        <Route path="/cart" element={<Auth Component={<Cart />} />} />
                        <Route path="/checkout" element={<Checkout />} />
                    </Routes>
                </Container>
            </Router>
        </CartProvider>
    );
}

export default App;
