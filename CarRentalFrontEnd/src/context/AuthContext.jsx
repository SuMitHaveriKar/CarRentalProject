import React, { createContext, useState, useContext, useEffect } from 'react';

const AuthContext = createContext();

// Provides authentication state (user, token) to the entire application
export const AuthProvider = ({ children }) => {
    // Initialize user state from local storage to persist login across refreshes
    const [user, setUser] = useState(() => {
        const savedUser = localStorage.getItem('user');
        return savedUser ? JSON.parse(savedUser) : null;
    });
    const [token, setToken] = useState(localStorage.getItem('token'));
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if (token) {
            const savedUser = localStorage.getItem('user');
            if (savedUser && !user) {
                setUser(JSON.parse(savedUser));
            }
            setLoading(false);
        } else {
            setLoading(false);
        }
    }, [token]);

    // Logs in the user, saving their data and token to local storage
    const login = (userData, authToken) => {
        setUser(userData);
        setToken(authToken);
        localStorage.setItem('token', authToken);
        localStorage.setItem('user', JSON.stringify(userData));
    };

    // Logs out the user, clearing all authentication data
    const logout = () => {
        setUser(null);
        setToken(null);
        localStorage.removeItem('token');
        localStorage.removeItem('user');
    };

    return (
        <AuthContext.Provider value={{ user, token, login, logout, loading }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
