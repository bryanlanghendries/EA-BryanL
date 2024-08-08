import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { AppBar, Toolbar, Typography, Button, Container, IconButton, Badge, CssBaseline } from '@mui/material';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import Catalog from './pages/Catalog';
import Home from './pages/Home';
import Cart from './pages/Cart';
import Checkout from './pages/Checkout';
import { CartProvider, useCart } from './context/CartContext';
import './App.css';

function Navbar() {
    const { getCartItemCount } = useCart();
    const cartItemCount = getCartItemCount();

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
                        <Route path="/catalog" element={<Catalog />} />
                        <Route path="/cart" element={<Cart />} />
                        <Route path="/checkout" element={<Checkout />} />
                    </Routes>
                </Container>
            </Router>
        </CartProvider>
    );
}

export default App;
